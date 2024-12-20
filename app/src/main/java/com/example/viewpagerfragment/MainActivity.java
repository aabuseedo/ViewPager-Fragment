package com.example.viewpagerfragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpagerfragment.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    ActivityMainBinding binding;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    ViewPagerFragmentAdapter adapter;


    private final String[] labels = new String[]{"Send", "Receives"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        init();

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(labels[position]);
        }).attach();

        viewPager2.setCurrentItem(0, false);
    }

    private void init() {
        tabLayout = binding.tabLayout;
        viewPager2 = binding.viewPager2;
        adapter = new ViewPagerFragmentAdapter(this);
        viewPager2.setAdapter(adapter);

        getSupportActionBar().setElevation(0);
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {
        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FirstPageFragment();
                case 1:
                    return new SecondPageFragment();
            }
            return new FirstPageFragment();
        }

        @Override
        public int getItemCount() {
            return labels.length;
        }
    }


    @Override
    public void onFragmentView(String text) {

        // التحقق من الفراجمنت الثاني وإعداد النص
        SecondPageFragment fragment = (SecondPageFragment) getSupportFragmentManager().findFragmentByTag("f1");
        if (fragment != null && fragment.getView() != null) {
            fragment.updateText(text);
        }
        viewPager2.setCurrentItem(1, true);

    }

}
