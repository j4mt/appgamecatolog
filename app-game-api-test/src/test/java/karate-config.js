function fn() {
    var config = {

        appCatalogUrl: 'http://localhost:8087/catalog/'
    };

    karate.configure('connectTimeout', 2000);
    karate.configure('readTimeout', 2000);

    return config;
}