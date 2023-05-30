import { funcAxios } from "./url";

export const signup = (user) => {
    return funcAxios.post("/adduser", user).then((response) => response.data)
}