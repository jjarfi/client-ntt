package com.github.jjarfi.sibntt.Api;

import com.github.jjarfi.sibntt.Service.MakananService;
import com.github.jjarfi.sibntt.Service.MusikService;
import com.github.jjarfi.sibntt.Service.PakaianService;
import com.github.jjarfi.sibntt.Service.RumahService;
import com.github.jjarfi.sibntt.Service.SejarahService;
import com.github.jjarfi.sibntt.Service.SukuService;
import com.github.jjarfi.sibntt.Service.TarianService;

public class API {
    public static final String URL_001 = "http://192.168.43.224:8083/api/";

    public static SukuService getSuku() {
        return Client.getApi(URL_001).create(SukuService.class);
    }

    public static MusikService getMusik() {
        return Client.getApi(URL_001).create(MusikService.class);
    }

    public static MakananService getMakanan() {
        return Client.getApi(URL_001).create(MakananService.class);
    }

    public static PakaianService getPakaian() {
        return Client.getApi(URL_001).create(PakaianService.class);
    }

    public static TarianService getTarian() {
        return Client.getApi(URL_001).create(TarianService.class);
    }

    public static SejarahService getSejarah() {
        return Client.getApi(URL_001).create(SejarahService.class);
    }
    public static RumahService getRumah() {
        return Client.getApi(URL_001).create(RumahService.class);
    }
}
