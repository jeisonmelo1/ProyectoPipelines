package com.advantageonlineshopping.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvantageLoombokData {

    private String usuario;
    private String clave;
    private String busqueda;


    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public static List<AdvantageLoombokData> setData(DataTable dataTable) {
        List<AdvantageLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, AdvantageLoombokData.class));
        }
        return dates;
    }
}
