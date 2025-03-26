package umcandroid.essential.week02_ex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umcandroid.essential.week02_ex.databinding.FragmentPencilBinding

class PencilFragment: Fragment(R.layout.fragment_pencil) {
    private lateinit var viewBinding: FragmentPencilBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPencilBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}