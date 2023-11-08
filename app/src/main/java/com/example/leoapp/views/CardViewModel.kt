package com.example.leoapp.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leoapp.data.dao.mant_reciboDAO
import com.example.leoapp.data.dao.mant_recibo_detDAO
import com.example.leoapp.data.model.mant_recibo
import com.example.leoapp.data.model.mant_recibo_det
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardViewModel : ViewModel() {
    private val dao = mant_reciboDAO()
    private val dao2 = mant_recibo_detDAO()

    private val _listaMantRecibo = MutableLiveData<List<mant_recibo>>()
    val listaMantRecibo: LiveData<List<mant_recibo>> = _listaMantRecibo

    private val _listaMantReciboDet = MutableLiveData<List<mant_recibo_det>>()
    val listaMantReciboDet: LiveData<List<mant_recibo_det>> = _listaMantReciboDet


    init {
        // Inicializar listaMantReciboDet con el ID que necesitas
        val idMantRecibo = 1 // Ajusta esto según tus necesidades
        viewModelScope.launch(Dispatchers.IO) {
            val result = dao2.getMantRecibo_DET(idMantRecibo)

            withContext(Dispatchers.Main) {
                _listaMantReciboDet.value = result
            }
        }

        // Inicializar listaMantRecibo
        viewModelScope.launch(Dispatchers.IO) {
            val result = dao.getMantRecibo()

            withContext(Dispatchers.Main) {
                _listaMantRecibo.value = result
            }
        }
    }
}
