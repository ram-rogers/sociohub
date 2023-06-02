import { funcAxios } from "./url";

export const login = (user) => {
    return funcAxios.post("/login", user).then((response) => response.data)
}