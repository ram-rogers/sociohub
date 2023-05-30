import axios from "axios"



export const BASE_URL = 'http://localhost:8080'

export const funcAxios = axios.create({
    baseURL: BASE_URL
})