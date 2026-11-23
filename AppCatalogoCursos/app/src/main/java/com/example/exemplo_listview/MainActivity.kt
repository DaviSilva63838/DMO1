package com.example.exemplo_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo_listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dao: CursoDao
    private lateinit var adapter: ArrayAdapter<String>

    private var cursos = listOf<Curso>()
    private var selecionado: Curso? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = AppDatabase.getInstance(this).cursoDao()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf<String>())
        binding.listCursos.adapter = adapter

        carregarLista()

        // Clique: mostra a descrição e preenche os campos pra editar/excluir
        binding.listCursos.setOnItemClickListener { _, _, position, _ ->
            val curso = cursos[position]
            selecionado = curso
            binding.txtDescricao.text = curso.descricao
            binding.edtNome.setText(curso.nome)
            binding.edtDescricao.setText(curso.descricao)
        }

        // INSERT
        binding.btnInserir.setOnClickListener {
            val nome = binding.edtNome.text.toString().trim()
            val desc = binding.edtDescricao.text.toString().trim()
            if (nome.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Preencha nome e descrição", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dao.insert(Curso(nome = nome, descricao = desc))
            limparCampos()
            carregarLista()
            Toast.makeText(this, "Curso inserido!", Toast.LENGTH_SHORT).show()
        }

        // UPDATE
        binding.btnAtualizar.setOnClickListener {
            val atual = selecionado
            if (atual == null) {
                Toast.makeText(this, "Selecione um curso na lista", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val nome = binding.edtNome.text.toString().trim()
            val desc = binding.edtDescricao.text.toString().trim()
            if (nome.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Preencha nome e descrição", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dao.update(Curso(atual.id, nome, desc))
            limparCampos()
            carregarLista()
            Toast.makeText(this, "Curso atualizado!", Toast.LENGTH_SHORT).show()
        }

        // DELETE
        binding.btnExcluir.setOnClickListener {
            val atual = selecionado
            if (atual == null) {
                Toast.makeText(this, "Selecione um curso na lista", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dao.delete(atual)
            limparCampos()
            carregarLista()
            Toast.makeText(this, "Curso excluído!", Toast.LENGTH_SHORT).show()
        }
    }

    // GET ALL: recarrega a lista a partir do banco
    private fun carregarLista() {
        cursos = dao.getAll()
        adapter.clear()
        adapter.addAll(cursos.map { it.nome })
        adapter.notifyDataSetChanged()
    }

    private fun limparCampos() {
        selecionado = null
        binding.edtNome.text.clear()
        binding.edtDescricao.text.clear()
        binding.txtDescricao.text = ""
    }
}