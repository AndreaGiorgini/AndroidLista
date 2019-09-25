package supergostei.example.com.lista;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    EditText edtProduto;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new Dao(this);
        dao.abrir();
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, dao.obterTodosOsProdutos(), new String[]{"nome"}, new int[]{android.R.id.text1});
        setListAdapter(adaptador);
        edtProduto = (EditText) findViewById(R.id.edtProduto);
    }

    public void onClickAdicionar(View v) {
        String produto = edtProduto.getText().toString();
        dao.inserirProduto(produto);
        SimpleCursorAdapter adaptador = (SimpleCursorAdapter) getListAdapter();
        adaptador.swapCursor(dao.obterTodosOsProdutos());
        edtProduto.setText("");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        dao.removerProduto(id);
        SimpleCursorAdapter adaptador = (SimpleCursorAdapter) getListAdapter();
        adaptador.swapCursor(dao.obterTodosOsProdutos());
    }

    @Override
    protected void onDestroy() {
        dao.fechar();
        super.onDestroy();
    }
}
