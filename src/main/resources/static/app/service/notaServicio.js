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

    SELF.post = (nota) => {
        return $q((success, error) => {
            factory.post(PATH, nota).then(
                (resolve) => {
                    success(resolve) 
                },
                (reject) => {
                    error(reject)
                })
        })
    }

    SELF.put = (nota) => {
        return $q((success, error) => {
            factory.put(PATH, nota).then(
                (resolve) => {
                    success(resolve) 
                },
                (reject) => {
                    error(reject)
                })
        })
    }

    SELF.delete = (nota) => {
        return $q((success, error) => {
            factory.delete(PATH, nota).then(
                (resolve) => {
                    success(resolve) 
                },
                (reject) => {
                    error(reject)
                })
        })
    }
})