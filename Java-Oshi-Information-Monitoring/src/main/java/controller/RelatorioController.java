package controller;

import org.json.JSONObject;
import service.RelatorioService;

public class RelatorioController {
    public static void main(String[] args)  {
        System.out.print(new JSONObject(RelatorioService.getRelatorio()).toString(5));
    }
}
