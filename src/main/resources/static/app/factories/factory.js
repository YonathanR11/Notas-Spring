app.factory("factory", function ($http, $q) {
    return {
        get: function ($url) {
            return $http({
                url: '/' + $url,
                method: 'GET'
            }).then((succes) => {
                return succes.data
            }, (error) => {
                return $q.reject(error);
            })
        },
        post: function ($url, data) {
            return $http({
                url: '/' + $url,
                method: 'POST',
                headers: { 'Content-Type': 'aplication/json' },
                data: data
            }).then((succes) => {
                return succes.data
            }, (error) => {
                return $q.reject(error);
            })
        },
        put: function ($url, data) {
            return $http({
                url: '/' + $url,
                method: 'PUT',
                headers: { 'Content-Type': 'aplication/json' },
                data: data
            }).then((succes) => {
                return succes.data
            }, (error) => {
                return $q.reject(error);
            })
        },
        delete: function ($url, data) {
            return $http({
                url: '/' + $url,
                method: 'DELETE',
                headers: { 'Content-Type': 'aplication/json' },
                data: data
            }).then((succes) => {
                return succes.data
            }, (error) => {
                return $q.reject(error);
            })
        }
    }
})
