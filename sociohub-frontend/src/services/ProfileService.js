import { funcAxios } from "./url";

export const profile = (profile) => {
    return funcAxios.post("/addprofile", profile).then((response) => response.data)
}