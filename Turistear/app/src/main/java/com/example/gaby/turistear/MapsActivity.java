package com.example.gaby.turistear;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//PAQUETES PARA STREET VIEW
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Iterator;

import static android.R.attr.data;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marcadorPosicionActual;
    private Marker marcadorAeropuerto;
    private Marker marcadorBanco1;
    private Marker marcadorBanco2;
    private Marker marcadorBanco3;
    private Marker marcadorBanco4;
    private Marker marcadorBanco5;
    private Marker marcadorBanco6;
    private Marker marcadorBanco7;
    private Marker marcadorBanco8;
    private Marker marcadorBanco9;
    private Marker marcadorBanco10;
    private Marker marcadorBar1;
    private Marker marcadorBar2;
    private Marker marcadorBar3;
    private Marker marcadorBar4;
    private Marker marcadorBar5;
    private Marker marcadorBar6;
    private Marker marcadorBar7;
    private Marker marcadorBar8;
    private Marker marcadorBar9;
    private Marker marcadorBar10;
    private Marker marcadorCementerio1;
    private Marker marcadorCementerio2;
    private Marker marcadorCine1;
    private Marker marcadorCine2;
    private Marker marcadorFarmacia1;
    private Marker marcadorFarmacia2;
    private Marker marcadorFarmacia3;
    private Marker marcadorFarmacia4;
    private Marker marcadorFarmacia5;
    private Marker marcadorFarmacia6;
    private Marker marcadorFarmacia7;
    private Marker marcadorFarmacia8;
    private Marker marcadorFarmacia9;
    private Marker marcadorFarmacia10;
    private Marker marcadorHospital1;
    private Marker marcadorHospital2;
    private Marker marcadorHospital3;
    private Marker marcadorHospital4;
    private Marker marcadorHospital5;
    private Marker marcadorHospital6;
    private Marker marcadorHospital7;
    private Marker marcadorHospital8;
    private Marker marcadorHospital9;
    private Marker marcadorHospital10;
    private Marker marcadorHotel1;
    private Marker marcadorHotel2;
    private Marker marcadorHotel3;
    private Marker marcadorHotel4;
    private Marker marcadorHotel5;
    private Marker marcadorHotel6;
    private Marker marcadorHotel7;
    private Marker marcadorHotel8;
    private Marker marcadorHotel9;
    private Marker marcadorHotel10;
    private Marker marcadorMuseo1;
    private Marker marcadorMuseo2;
    private Marker marcadorMuseo3;
    private Marker marcadorMuseo4;
    private Marker marcadorMuseo5;
    private Marker marcadorMuseo6;
    private Marker marcadorMuseo7;
    private Marker marcadorMuseo8;
    private Marker marcadorMuseo9;
    private Marker marcadorMuseo10;
    private Marker marcadorParque1;
    private Marker marcadorParque2;
    private Marker marcadorParque3;
    private Marker marcadorParque4;
    private Marker marcadorParque5;
    private Marker marcadorParque6;
    private Marker marcadorParque7;
    private Marker marcadorParque8;
    private Marker marcadorParque9;
    private Marker marcadorParque10;
    private Marker marcadorRestaurante1;
    private Marker marcadorRestaurante2;
    private Marker marcadorRestaurante3;
    private Marker marcadorRestaurante4;
    private Marker marcadorRestaurante5;
    private Marker marcadorRestaurante6;
    private Marker marcadorRestaurante7;
    private Marker marcadorRestaurante8;
    private Marker marcadorRestaurante9;
    private Marker marcadorRestaurante10;
    private Marker marcadorTeatro1;
    private Marker marcadorTeatro2;
    private Marker marcadorTeatro3;
    private Marker marcadorUniversidad1;
    private Marker marcadorUniversidad2;
    private Marker marcadorUniversidad3;
    LatLng coordenadas;
    double lat = 0.0;
    double lng = 0.0;
    double latStreet=0.0;
    double longStreet=0.0;
    int cont=-1;
    Integer tipo=1;
    String mapa;
    String nombre;
    Button btnMapa;
    private final static int MY_PERMISSION_FINE_LOCATION=101;
    String[] categorias = new String[13] ;

    Switch switchSalirStreetView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS) {

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            btnMapa=(Button)findViewById(R.id.btnMapa);
            btnMapa.setOnClickListener(new View.OnClickListener(){

                //sirve para los diferentes tipos de mapa
                public void onClick(View view){

                    switch (tipo){
                        case 1: mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            mapa="MAPA HIBRIDO";
                            tipo=2;
                            break;
                        case 2: mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            mapa="MAPA SATELITE";
                            tipo=3;
                            break;
                        case 3: mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                            mapa="MAPA TERRENO";
                            tipo=4;
                            break;
                        case 4: mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            mapa="MAPA NORMAL";
                            tipo=1;
                            break;
                    }
                    Toast toast=Toast.makeText(getApplicationContext(),mapa,Toast.LENGTH_SHORT);
                    toast .show();
                }
            });


        } else {

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, (Activity) getApplicationContext(), 10);
            dialog.show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        clickMarcador();
        float zoomCuenca=12;

        UiSettings uiSettings=mMap.getUiSettings();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);

        miUbicacion(); //sirve para poner un marcador y tener las coordenadas
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,zoomCuenca));
        agregarMarcador();
    }

    public void clickMarcador(){

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng ll = marker.getPosition();
                latStreet=ll.latitude;
                longStreet=ll.longitude;
                streetView();
                return false;
            }
        });
    }

    public void streetView(){

        setContentView(R.layout.activity_street_view);


        switchSalirStreetView = (Switch)findViewById(R.id.switchSalir);
        switchSalirStreetView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchSalirStreetView.isChecked()){
                    //Toast.makeText(getApplicationContext(),"pulsaste ",Toast.LENGTH_SHORT).show();
                    Intent inten = new Intent(MapsActivity.this,MapsActivity.class);
                    startActivity(inten);
                }
            }
        });

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                        LatLng ubicacion= new LatLng(latStreet, longStreet);
                        panorama.setPosition(ubicacion);
                    }
                });
    }

    /*public void abrirVentana(){

        //es para poner la ventana de latitud y longitud
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window,null);
                TextView latitud = (TextView)v.findViewById(R.id.tvLat);
                TextView longitud = (TextView)v.findViewById(R.id.tvLng);
                TextView texto = (TextView)v.findViewById(R.id.tvText);
                Button street = (Button)v.findViewById(R.id.streetView);

                LatLng ll = marker.getPosition();
                String nuevo = "Latitud: "+ll.latitude;
                String nuevo1 = "Longitud: "+ll.longitude;
                //String nuevo2 = "Mi posicion Actual";
                latitud.setText(nuevo);
                longitud.setText(nuevo1);
                texto.setText(nombre);
                street.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View arg0){

                        Toast.makeText(getApplicationContext(),"entro ",Toast.LENGTH_SHORT).show();
                        Intent inten = new Intent(MapsActivity.this,StreetView.class);
                        startActivity(inten);
                    }
                });
                return v;
            }
        });
    }*/

    public void marcadorGPS(double lat, double lng){

        coordenadas = new LatLng(lat,lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);

        //MARCADOR DE MI POSICION ACTUAL
        if (marcadorPosicionActual != null) marcadorPosicionActual.remove();
        marcadorPosicionActual = mMap.addMarker(new MarkerOptions().
                position(coordenadas).title("Mi posicion actual").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin1)));
    }


    public void llenarCategorias(String[] args1){

        final AyudaBD ayudabd = new AyudaBD(getApplicationContext());
        SQLiteDatabase db = ayudabd.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Tabla Where nombre=? ",args1);
        if(c.moveToFirst()){
            //Toast.makeText(getApplicationContext(),"entro" ,Toast.LENGTH_SHORT).show();
            do{
                //Toast.makeText(getApplicationContext(),"cate "+c.getString(4) ,Toast.LENGTH_SHORT).show();
                cont++;
                categorias[cont]=c.getString(4);
            }while(c.moveToNext());
        }
    }

    public void agregarMarcador() {

        String latitud="", longitud="", nombre="", a="", lugar="";
        String[] args1 = new String[] {"opc1"};
        llenarCategorias(args1);
        String[] args2 = new String[] {"opc2"};
        llenarCategorias(args2);
        String[] args3 = new String[] {"opc3"};
        llenarCategorias(args3);
        String[] args4 = new String[] {"opc4"};
        llenarCategorias(args4);
        String[] args5 = new String[] {"opc5"};
        llenarCategorias(args5);
        String[] args6 = new String[] {"opc6"};
        llenarCategorias(args6);
        String[] args7 = new String[] {"opc7"};
        llenarCategorias(args7);
        String[] args8 = new String[] {"opc8"};
        llenarCategorias(args8);
        String[] args9 = new String[] {"opc9"};
        llenarCategorias(args9);
        String[] args10 = new String[] {"opc10"};
        llenarCategorias(args10);
        String[] args11 = new String[] {"opc11"};
        llenarCategorias(args11);
        String[] args12 = new String[] {"opc12"};
        llenarCategorias(args12);
        String[] args13 = new String[] {"opc13"};
        llenarCategorias(args13);

        final AyudaBD ayudabd = new AyudaBD(getApplicationContext());
        SQLiteDatabase db = ayudabd.getWritableDatabase();
        for(int i=0; i<=cont; i++){
            a=categorias[i];
            //Toast.makeText(getApplicationContext(),"vale "+a,Toast.LENGTH_SHORT).show();
            if(a!=null){
                switch(a){
                    case "aeropuerto":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Aeropuerto"};
                        Cursor c = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        if(c.moveToFirst()){
                            do{
                            nombre = c.getString(1);
                            latitud = c.getString(2);
                            longitud = c.getString(3);
                            //Toast.makeText(getApplicationContext(),"nombre " +nombre,Toast.LENGTH_SHORT).show();
                            }while(c.moveToNext());
                        }
                        double lat1 = 0.0;
                        double lng1 = 0.0;
                        lat1 = Float.parseFloat(latitud);
                        lng1 = Float.parseFloat(longitud);
                        LatLng mAeropuerto = new LatLng(lat1, lng1);
                        if (marcadorAeropuerto != null) marcadorAeropuerto.remove();
                        marcadorAeropuerto = mMap.addMarker(new MarkerOptions().
                                position(mAeropuerto).title(nombre).
                                icon(BitmapDescriptorFactory.fromResource(R.mipmap.aeropuerto1)));
                        break;

                    case "banco":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Banco"};
                        Cursor c1 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        int num=-1;
                        if(c1.moveToFirst()){
                            do{
                                num++;
                                nombre = c1.getString(1);
                                latitud = c1.getString(2);
                                longitud = c1.getString(3);
                                double lat2 = 0.0;
                                double lng2 = 0.0;
                                lat2 = Float.parseFloat(latitud);
                                lng2 = Float.parseFloat(longitud);

                                if(num==0){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco1 != null) marcadorBanco1.remove();
                                    marcadorBanco1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco2 != null) marcadorBanco2.remove();
                                    marcadorBanco2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco3 != null) marcadorBanco2.remove();
                                    marcadorBanco3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco4 != null) marcadorBanco4.remove();
                                    marcadorBanco4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco5 != null) marcadorBanco5.remove();
                                    marcadorBanco5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco6 != null) marcadorBanco6.remove();
                                    marcadorBanco6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco7 != null) marcadorBanco7.remove();
                                    marcadorBanco7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco8 != null) marcadorBanco8.remove();
                                    marcadorBanco8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco9 != null) marcadorBanco9.remove();
                                    marcadorBanco9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat2, lng2);
                                    if (marcadorBanco10 != null) marcadorBanco10.remove();
                                    marcadorBanco10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1)));
                                }
                            }while(c1.moveToNext());
                        }

                        break;

                    case "bar":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Bar-Discoteca"};
                        Cursor c2 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c2.moveToFirst()){
                            do{
                                num++;
                                nombre = c2.getString(1);
                                latitud = c2.getString(2);
                                longitud = c2.getString(3);
                                double lat3 = 0.0;
                                double lng3 = 0.0;
                                lat3 = Float.parseFloat(latitud);
                                lng3 = Float.parseFloat(longitud);

                                if(num==0){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar1 != null) marcadorBar1.remove();
                                    marcadorBar1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar2 != null) marcadorBar2.remove();
                                    marcadorBar2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar3 != null) marcadorBar3.remove();
                                    marcadorBar3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar4 != null) marcadorBar4.remove();
                                    marcadorBar4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar5 != null) marcadorBar5.remove();
                                    marcadorBar5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar6 != null) marcadorBar6.remove();
                                    marcadorBar6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar7 != null) marcadorBar7.remove();
                                    marcadorBar7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar8 != null) marcadorBar8.remove();
                                    marcadorBar8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar9 != null) marcadorBar9.remove();
                                    marcadorBar9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat3, lng3);
                                    if (marcadorBar10 != null) marcadorBar10.remove();
                                    marcadorBar10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1)));
                                }
                            }while(c2.moveToNext());
                        }

                        break;

                    case "cementerio":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Cementerio"};
                        Cursor c3 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c3.moveToFirst()){
                            do{
                                num++;
                                nombre = c3.getString(1);
                                latitud = c3.getString(2);
                                longitud = c3.getString(3);
                                double lat4 = 0.0;
                                double lng4 = 0.0;
                                lat4 = Float.parseFloat(latitud);
                                lng4 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat4, lng4);
                                    if (marcadorCementerio1 != null) marcadorCementerio1.remove();
                                    marcadorCementerio1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cementerio1)));
                                }else{
                                    LatLng mBanco = new LatLng(lat4, lng4);
                                    if (marcadorCementerio2 != null) marcadorCementerio2.remove();
                                    marcadorCementerio2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cementerio1)));
                                }
                            }while(c3.moveToNext());
                        }
                        break;

                    case "cine":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Cine"};
                        Cursor c4 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c4.moveToFirst()){
                            do{
                                num++;
                                nombre = c4.getString(1);
                                latitud = c4.getString(2);
                                longitud = c4.getString(3);
                                double lat5 = 0.0;
                                double lng5 = 0.0;
                                lat5 = Float.parseFloat(latitud);
                                lng5 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat5, lng5);
                                    if (marcadorCine1 != null) marcadorCine1.remove();
                                    marcadorCine1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cine1)));
                                }else{
                                    LatLng mBanco = new LatLng(lat5, lng5);
                                    if (marcadorCine2 != null) marcadorCine2.remove();
                                    marcadorCine2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cine1)));
                                }
                            }while(c4.moveToNext());
                        }
                        break;

                    case "farmacia":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Farmacia"};
                        Cursor c5 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c5.moveToFirst()){
                            do{
                                num++;
                                nombre = c5.getString(1);
                                latitud = c5.getString(2);
                                longitud = c5.getString(3);
                                double lat6 = 0.0;
                                double lng6 = 0.0;
                                lat6 = Float.parseFloat(latitud);
                                lng6 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia1 != null) marcadorFarmacia1.remove();
                                    marcadorFarmacia1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia2 != null) marcadorFarmacia2.remove();
                                    marcadorFarmacia2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia3 != null) marcadorFarmacia3.remove();
                                    marcadorFarmacia3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia4 != null) marcadorFarmacia4.remove();
                                    marcadorFarmacia4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia5 != null) marcadorFarmacia5.remove();
                                    marcadorFarmacia5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia6 != null) marcadorFarmacia6.remove();
                                    marcadorFarmacia6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia7 != null) marcadorFarmacia7.remove();
                                    marcadorFarmacia7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia8 != null) marcadorFarmacia8.remove();
                                    marcadorFarmacia8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia9 != null) marcadorFarmacia9.remove();
                                    marcadorFarmacia9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat6, lng6);
                                    if (marcadorFarmacia10 != null) marcadorFarmacia10.remove();
                                    marcadorFarmacia10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1)));
                                }
                            }while(c5.moveToNext());
                        }
                        break;

                    case "hospital":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Hospital"};
                        Cursor c6 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c6.moveToFirst()){
                            do{
                                num++;
                                nombre = c6.getString(1);
                                latitud = c6.getString(2);
                                longitud = c6.getString(3);
                                double lat7 = 0.0;
                                double lng7 = 0.0;
                                lat7 = Float.parseFloat(latitud);
                                lng7 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital1 != null) marcadorHospital1.remove();
                                    marcadorHospital1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital2 != null) marcadorHospital2.remove();
                                    marcadorHospital2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital3 != null) marcadorHospital3.remove();
                                    marcadorHospital3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital4 != null) marcadorHospital4.remove();
                                    marcadorHospital4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital5 != null) marcadorHospital5.remove();
                                    marcadorHospital5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital6 != null) marcadorHospital6.remove();
                                    marcadorHospital6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital7 != null) marcadorHospital7.remove();
                                    marcadorHospital7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital8 != null) marcadorHospital8.remove();
                                    marcadorHospital8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital9 != null) marcadorHospital9.remove();
                                    marcadorHospital9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat7, lng7);
                                    if (marcadorHospital10 != null) marcadorHospital10.remove();
                                    marcadorHospital10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1)));
                                }

                            }while(c6.moveToNext());
                        }
                        break;

                    case "hotel":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Hotel"};
                        Cursor c7 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c7.moveToFirst()){
                            do{
                                num++;
                                nombre = c7.getString(1);
                                latitud = c7.getString(2);
                                longitud = c7.getString(3);
                                double lat8 = 0.0;
                                double lng8 = 0.0;
                                lat8 = Float.parseFloat(latitud);
                                lng8 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel1 != null) marcadorHotel1.remove();
                                    marcadorHotel1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel2 != null) marcadorHotel2.remove();
                                    marcadorHotel2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel3 != null) marcadorHotel3.remove();
                                    marcadorHotel3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel4 != null) marcadorHotel4.remove();
                                    marcadorHotel4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel5 != null) marcadorHotel5.remove();
                                    marcadorHotel5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel6 != null) marcadorHotel6.remove();
                                    marcadorHotel6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel7 != null) marcadorHotel7.remove();
                                    marcadorHotel7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel8 != null) marcadorHotel8.remove();
                                    marcadorHotel8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel9 != null) marcadorHotel9.remove();
                                    marcadorHotel9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat8, lng8);
                                    if (marcadorHotel10 != null) marcadorHotel10.remove();
                                    marcadorHotel10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1)));
                                }
                            }while(c7.moveToNext());
                        }
                        break;

                    case "museo":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Museo"};
                        Cursor c8 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c8.moveToFirst()){
                            do{
                                num++;
                                nombre = c8.getString(1);
                                latitud = c8.getString(2);
                                longitud = c8.getString(3);
                                double lat9 = 0.0;
                                double lng9 = 0.0;
                                lat9 = Float.parseFloat(latitud);
                                lng9 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo1 != null) marcadorMuseo1.remove();
                                    marcadorMuseo1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==1){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo2 != null) marcadorMuseo2.remove();
                                    marcadorMuseo2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==2){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo3 != null) marcadorMuseo3.remove();
                                    marcadorMuseo3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==3){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo4 != null) marcadorMuseo4.remove();
                                    marcadorMuseo4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==4){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo5 != null) marcadorMuseo5.remove();
                                    marcadorMuseo5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==5){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo6 != null) marcadorMuseo6.remove();
                                    marcadorMuseo6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==6){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo7 != null) marcadorMuseo7.remove();
                                    marcadorMuseo7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==7){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo8 != null) marcadorMuseo8.remove();
                                    marcadorMuseo8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==8){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo9 != null) marcadorMuseo9.remove();
                                    marcadorMuseo9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }else if (num==9){
                                    LatLng mBanco = new LatLng(lat9, lng9);
                                    if (marcadorMuseo10 != null) marcadorMuseo10.remove();
                                    marcadorMuseo10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1)));
                                }
                            }while(c8.moveToNext());
                        }
                        break;

                    case "parque":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Parque"};
                        Cursor c9 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c9.moveToFirst()){
                            do{
                                num++;
                                nombre = c9.getString(1);
                                latitud = c9.getString(2);
                                longitud = c9.getString(3);
                                double lat10 = 0.0;
                                double lng10 = 0.0;
                                lat10 = Float.parseFloat(latitud);
                                lng10 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque1 != null) marcadorParque1.remove();
                                    marcadorParque1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque2 != null) marcadorParque2.remove();
                                    marcadorParque2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque3 != null) marcadorParque3.remove();
                                    marcadorParque3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==3){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque4 != null) marcadorParque4.remove();
                                    marcadorParque4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==4){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque5 != null) marcadorParque5.remove();
                                    marcadorParque5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==5){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque6 != null) marcadorParque6.remove();
                                    marcadorParque6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==6){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque7 != null) marcadorParque7.remove();
                                    marcadorParque7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==7){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque8 != null) marcadorParque8.remove();
                                    marcadorParque8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==8){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque9 != null) marcadorParque9.remove();
                                    marcadorParque9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }else if(num==9){
                                    LatLng mBanco = new LatLng(lat10, lng10);
                                    if (marcadorParque10 != null) marcadorParque10.remove();
                                    marcadorParque10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1)));
                                }
                            }while(c9.moveToNext());
                        }
                        break;

                    case "restaurante":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Restaurante"};
                        Cursor c10 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c10.moveToFirst()){
                            do{
                                num++;
                                nombre = c10.getString(1);
                                latitud = c10.getString(2);
                                longitud = c10.getString(3);
                                double lat11 = 0.0;
                                double lng11 = 0.0;
                                lat11 = Float.parseFloat(latitud);
                                lng11 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante1 != null) marcadorRestaurante1.remove();
                                    marcadorRestaurante1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==1) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante2 != null) marcadorRestaurante2.remove();
                                    marcadorRestaurante2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==2) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante3 != null) marcadorRestaurante3.remove();
                                    marcadorRestaurante3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==3) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante4 != null) marcadorRestaurante4.remove();
                                    marcadorRestaurante4 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==4) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante5 != null) marcadorRestaurante5.remove();
                                    marcadorRestaurante5 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==5) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante6 != null) marcadorRestaurante6.remove();
                                    marcadorRestaurante6 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==6) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante7 != null) marcadorRestaurante7.remove();
                                    marcadorRestaurante7 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==7) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante8 != null) marcadorRestaurante8.remove();
                                    marcadorRestaurante8 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==8) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante9 != null) marcadorRestaurante9.remove();
                                    marcadorRestaurante9 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }else if(num==9) {
                                    LatLng mBanco = new LatLng(lat11, lng11);
                                    if (marcadorRestaurante10 != null) marcadorRestaurante10.remove();
                                    marcadorRestaurante10 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
                                }
                            }while(c10.moveToNext());
                        }
                        break;

                    case "teatro":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Teatro"};
                        Cursor c11 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c11.moveToFirst()){
                            do{
                                num++;
                                nombre = c11.getString(1);
                                latitud = c11.getString(2);
                                longitud = c11.getString(3);
                                double lat12 = 0.0;
                                double lng12 = 0.0;
                                lat12 = Float.parseFloat(latitud);
                                lng12 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat12, lng12);
                                    if (marcadorTeatro1 != null) marcadorTeatro1.remove();
                                    marcadorTeatro1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.teatro1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat12, lng12);
                                    if (marcadorTeatro2 != null) marcadorTeatro2.remove();
                                    marcadorTeatro2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.teatro1)));
                                }else{
                                    LatLng mBanco = new LatLng(lat12, lng12);
                                    if (marcadorTeatro3 != null) marcadorTeatro3.remove();
                                    marcadorTeatro3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.teatro1)));
                                }
                            }while(c11.moveToNext());
                        }
                        break;

                    case "universidad":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Universidad"};
                        Cursor c12 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c12.moveToFirst()){
                            do{
                                num++;
                                nombre = c12.getString(1);
                                latitud = c12.getString(2);
                                longitud = c12.getString(3);
                                double lat13 = 0.0;
                                double lng13 = 0.0;
                                lat13 = Float.parseFloat(latitud);
                                lng13 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat13, lng13);
                                    if (marcadorUniversidad1 != null) marcadorUniversidad1.remove();
                                    marcadorUniversidad1= mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.universidad1)));
                                }else if(num==1){
                                    LatLng mBanco = new LatLng(lat13, lng13);
                                    if (marcadorUniversidad2 != null) marcadorUniversidad2.remove();
                                    marcadorUniversidad2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.universidad1)));
                                }else if(num==2){
                                    LatLng mBanco = new LatLng(lat13, lng13);
                                    if (marcadorUniversidad3 != null) marcadorUniversidad3.remove();
                                    marcadorUniversidad3 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.universidad1)));
                                }
                            }while(c12.moveToNext());
                        }
                        break;
                }
            }
        }

    }
    //public void agregarMarcador1(/*String lugar, String nombre, String latitud, String longitud*/) {

        /*String latitud="", longitud="", nombre="";


        SQLiteDatabase db = miBaseDatos.getWritableDatabase();
        String[] args = new String[] {"aeropuerto"};
        Cursor c = db.rawQuery(DatosTabla1.COLUMNA_LUGAR+"=?",args);
        /*if(c.moveToFirst()){
            do{
                nombre = c.getString(0);
                latitud = c.getString(1);
                longitud = c.getString(2);
                Toast.makeText(getApplicationContext(), ""+nombre+""+latitud+""+longitud, Toast.LENGTH_LONG).show();
            }while(c.moveToNext());
        }*/
        //lat = Integer.parseInt(latitud);
        //lng = Integer.parseInt(longitud);
        /*lat = Integer.parseInt(latitud);
        lng = Integer.parseInt(longitud);
        //Marcadores Aeropuerto
        if(lugar=="aeropuerto"){
            LatLng mAeropuerto = new LatLng(lat, lng);
            if (marcadorRestaurante != null) marcadorRestaurante.remove();
            marcadorRestaurante = mMap.addMarker(new MarkerOptions().
                    position(mAeropuerto).title(nombre).
                    icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
        }*/
        /*LatLng mRestaurante = new LatLng(lat, lng);
        if (marcadorRestaurante != null) marcadorRestaurante.remove();
        marcadorRestaurante = mMap.addMarker(new MarkerOptions().
                position(mRestaurante).title(nombre).
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));

        /*LatLng mRestaurante2 = new LatLng(-2.900850321505161, -79.00559858825841);
        if (marcadorRestaurante2 != null) marcadorRestaurante2.remove();
        marcadorRestaurante2 = mMap.addMarker(new MarkerOptions().
                position(mRestaurante2).title("Restaurante").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));*/

        //mMap.animateCamera(miUbicacion); //esto hace que de una se muestre donde esta de forma acercada*/
    //}

    //ESTE METODO SIRVE PARA OBTENER LA LATITUD Y LONGITUD DE NUESTRA POSICION ACTUAL
    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            marcadorGPS(lat, lng);
            //agregarMarcador();
        }
    }

    LocationListener locListener = new LocationListener() {

        //RECIBE LA ACTUALIZACION DE LA LOCALIZACION DE LA POSICION
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);//PBETENER SERVICIOS DE GEO POSICIONAMIENTO EN EL DISPOSITIVO
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); //OBTENGO MI UTIMA POSICION CONOCIDA
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener); //SOLICITO AL GPS ACTUALIZACION DE POSICION CADA 15 SEG.
    }
}
