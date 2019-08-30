// app.service('loginService', function ($q, factory) {
//     const SELF = this;
//     const PATH = "login";

//     SELF.postLogin = (login) => {
//         return $q((success, error) => {
//             factory.post(PATH, login).then(
//                 (resolve) => {
//                     console.log("A");
//                     success(resolve)
//                 },
//                 (reject) => {
//                     console.log("B: ",reject);
//                     error(reject)
//                 })
//         })
//     }
// })