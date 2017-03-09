package com.bni.umkm.bniumkm;
        import android.content.Context;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.FrameLayout;
        import android.widget.TextView;
        import android.widget.Toast;

public class calculator extends Fragment {
    Button btn_hitung;
    EditText nilai_pinjaman, nilai_bulan;
    TextView bunga, total;

    public calculator() {
        // Required empty publ  ic constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator, container, false);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.calculator, container, false);
        btn_hitung = (Button) view.findViewById(R.id.hitung);
        nilai_pinjaman = (EditText) view.findViewById(R.id.nilai_pinjaman);
        nilai_bulan = (EditText) view.findViewById(R.id.nilai_bulan);
        bunga = (TextView) view.findViewById(R.id.bunga);
        total = (TextView) view.findViewById(R.id.total);
        btn_hitung.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String a = nilai_pinjaman.getText().toString();
                String b = nilai_bulan.getText().toString();
                String c = bunga.getText().toString();
                double nilai = Double.parseDouble(a);
                double bulanan = Double.parseDouble(b);
                double bungaa = Double.parseDouble(c);
                double bungan = (double)bungaa/100;
                double cicilan_pokok = nilai / bulanan;
                double jml_bunga = (nilai * bungan) / bulanan;
                double jumlah = cicilan_pokok + jml_bunga;
                String as = String.valueOf(jumlah);
                total.setText(as);
            }
        });
        return view;
    }



}