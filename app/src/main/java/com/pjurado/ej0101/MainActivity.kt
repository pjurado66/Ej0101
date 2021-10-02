package com.pjurado.ej0101

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import com.pjurado.ej0101.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMarcar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:962849347"))
            startActivity(intent)
        }

        binding.btnBuscar.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "IES Hermanos Machado")
            startActivity(intent)
        }

        binding.btnContactos.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ieshnosmachado.org")))
        }

        binding.btnCamara.setOnClickListener {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        binding.btnMapa.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.349930738900305, -5.9436511766212226")))
        }
    }
}