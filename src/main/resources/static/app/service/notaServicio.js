app.service('notaService', function ($q, factory) {
    const SELF = this;
    const PATH = "notas";

    SELF.get = () => {
        return $q((success, error) => {
            factory.get(PATH).then(
                (resolve) => {
                    success(resolve) 
                },
                (reject) => {
                    error(reject)
                })
        })
    }






    // SELF.post = function (nota) {
    //     return $q(function (success, error) {
    //         factory.post(PATH, nota).then((succes) => {
    //             resolve();
    //         }, (error) => {
    //             reject();
    //         });
    //     })
    // }
    // SELF.put = function (nota) {
    //     return $q(function (success, error) {
    //         factory.put(PATH, nota).then((succes) => {
    //             resolve();
    //         }, (error) => {
    //             reject();
    //         });
    //     })
    // }
    // SELF.delete = function (nota) {
    //     return $q(function (success, error) {
    //         factory.delete(PATH, nota).then((succes) => {
    //             resolve();
    //         }, (error) => {
    //             reject();
    //         });
    //     })
    // }
})