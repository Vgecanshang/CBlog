package com.cy.cblog.ui.setting

import android.os.Bundle
import android.view.MenuItem
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.cy.cblog.R
import com.cy.cblog.databinding.ActivitySettingsBinding
import com.cy.cblog.frame.CActivity

/**
 * 设置
 * @author Cyong
 * @date 2020/6/17 16:10
 */
class SettingActivity:CActivity() {

    private lateinit var binding:ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings , SettingsFragment())
            .commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            //setDisplayHomeAsUpEnabled后监听返回按钮事件
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            //取值
            val value = findPreference<EditTextPreference>("signature")?.text
            println("PreferenceFragmentCompat onCreatePreferences signature=$value")
        }


        override fun onPreferenceTreeClick(preference: Preference?): Boolean {
            //监听设置项点击事件
            if(preference?.key == "signature"){
                //签名
            }
            when(preference?.key){
                "signature" ->{
                    val value = findPreference<EditTextPreference>("signature")?.text
                    println("PreferenceFragmentCompat onPreferenceTreeClick signature=$value")
                }
                "reply" -> {
                    val value = findPreference<ListPreference>("reply")?.value
                    println("PreferenceFragmentCompat onPreferenceTreeClick reply=$value")
                }
                else ->
                    println("PreferenceFragmentCompat onPreferenceTreeClick error type.${preference?.key}")
            }

            return super.onPreferenceTreeClick(preference)
        }
    }
}