/*
 * Copyright 2016 "Henry Tao <hi@henrytao.me>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.henrytao.smoothappbarlayoutdemo.apdater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import me.henrytao.smoothappbarlayout.base.ObservableFragment;
import me.henrytao.smoothappbarlayout.base.ObservablePagerAdapter;

/**
 * Created by henrytao on 2/6/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter implements ObservablePagerAdapter {

  private final List<Fragment> mFragments = new ArrayList<>();

  private final List<CharSequence> mTitles = new ArrayList<>();

  public ViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public int getCount() {
    return mFragments.size();
  }

  @Override
  public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override
  public ObservableFragment getObservableFragment(int position) {
    if (getItem(position) instanceof ObservableFragment) {
      return (ObservableFragment) getItem(position);
    }
    return null;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mTitles.get(position);
  }

  public void addFragment(CharSequence title, Fragment fragment) {
    mTitles.add(title);
    mFragments.add(fragment);
  }
}
