package umcandroid.essential.week02_ex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import umcandroid.essential.week02_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

//        enableEdgeToEdge()
        setContentView(viewBinding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // 기본 프래그먼트 설정
        if (savedInstanceState == null) {
            loadFragment(HomeFragment(), false)
        }

        // BottomNavigationView 아이템 클릭 이벤트 처리
        viewBinding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment(), true)
                R.id.nav_pencil -> loadFragment(PencilFragment(), true)
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment, withAnimation: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        if (withAnimation) {
            transaction.setCustomAnimations(
                android.R.anim.slide_in_left,  // 새 Fragment가 왼쪽에서 들어옴
                android.R.anim.slide_out_right // 기존 Fragment가 오른쪽으로 나감
            )
        }

        transaction.replace(R.id.frame_fragment, fragment)
            .commitAllowingStateLoss()
    }
}