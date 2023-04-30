import axios from "axios";

/** axios 설정 **/
const config = {
    baseURL: 'http://localhost'
}

const axiosInstance = axios.create(config);

axiosInstance.defaults.timeout = 2500;

/** 요청 인터셉터 **/
axiosInstance.interceptors.request.use(
    config => {
        return config
    }, error => {
        console.log(error);
        return Promise.reject(error);
    }
);

/** 응답 인터셉터 **/
axiosInstance.interceptors.response.use(
    response => {
        return response.data;
    },
    error => {
        console.log(error);
        return Promise.reject(error);
    }
);

export default axiosInstance;