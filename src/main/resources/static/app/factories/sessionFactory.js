app.factory("sessionFactory", function () {

    return {
        get: function ($keyId) {
            return JSON.parse(sessionStorage.getItem($keyId));
        },
        put: function ($nombre, $objUser) {
            let user = JSON.stringify($objUser);
            sessionStorage.setItem($nombre, user)
        },
        delete: function ($keyId) {
            return sessionStorage.removeItem($keyId);
        },
        deleteAll: function () {
            return sessionStorage.clear();
        }
    }
});