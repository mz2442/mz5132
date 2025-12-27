package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 设置工具栏
        setupToolbar()
        
        // 设置系统栏适配
        setupWindowInsets()
        
        // 设置各种功能按钮
        setupButtons()
    }

    private fun setupToolbar() {
        // 设置工具栏
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.profile_activity_title)
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupButtons() {
        // 编辑资料按钮
        findViewById<MaterialButton>(R.id.edit_profile_btn)?.setOnClickListener {
            showToast("正在打开编辑资料界面...")
            simulateEditProfile()
        }

        // 高级设置按钮
        findViewById<MaterialButton>(R.id.settings_btn)?.setOnClickListener {
            showToast("正在打开高级设置...")
            simulateAdvancedSettings()
        }

        // 退出登录按钮
        findViewById<MaterialButton>(R.id.logout_btn)?.setOnClickListener {
            showToast("正在退出登录...")
            simulateLogout()
        }

        // 设置选项列表点击事件
        setupListItemClicks()
    }

    private fun setupListItemClicks() {
        // 账户安全设置
        findViewById<LinearLayout?>(R.id.security_layout)?.setOnClickListener {
            showToast("🔒 账户安全设置已打开\n✅ 双因子认证: 已启用\n🛡️ 设备绑定: 2台")
        }

        // 隐私设置
        findViewById<LinearLayout?>(R.id.privacy_layout)?.setOnClickListener {
            showToast("👥 隐私设置已优化\n📍 位置信息: 仅使用时\n🔒 个人资料可见度: 私密")
        }

        // 通知设置
        findViewById<LinearLayout?>(R.id.notifications_layout)?.setOnClickListener {
            showToast("🔔 通知设置已打开\n📱 推送通知: 已启用\n📧 邮件提醒: 重要时")
        }

        // 外观设置
        findViewById<LinearLayout?>(R.id.appearance_layout)?.setOnClickListener {
            showToast("🎨 外观设置已打开\n🌙 主题: 深色模式\n🌐 语言: 简体中文\n📏 字体大小: 中等")
        }
    }

    private fun simulateEditProfile() {
        // 模拟编辑资料流程
        showToast("📝 个人信息更新中...")
        
        // 模拟网络请求延迟
        android.os.Handler(mainLooper).postDelayed({
            showToast("✅ 个人信息更新成功！\n📸 头像已更新\n📝 简介已修改\n🏷️ 标签已添加")
        }, 1500)
    }

    private fun simulateAdvancedSettings() {
        // 模拟高级设置界面
        showToast("⚙️ 高级设置加载中...")
        
        android.os.Handler(mainLooper).postDelayed({
            showToast("🔧 高级设置功能:\n🎯 个性化推荐: 开启\n📊 数据分析: 详细\n🌐 API访问: 受限\n🔄 自动同步: 开启")
        }, 1000)
    }

    private fun simulateLogout() {
        // 模拟退出登录流程
        showToast("👋 正在清理数据...")
        
        android.os.Handler(mainLooper).postDelayed({
            showToast("✅ 已安全退出\n🔐 会话已清除\n💾 数据已保存\n🔄 下次登录将重新获取数据")
            
            // 返回主页面
            finish()
        }, 2000)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}