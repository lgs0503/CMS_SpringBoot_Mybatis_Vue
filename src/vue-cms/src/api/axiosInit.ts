import axios from "axios";
import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";

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
        const alertConfirm = useAlertConfirmStore();
        alertConfirm.alert("서버 응답 에러 : 관리자에게 문의하세요");
        console.log(error);
        return Promise.reject(error);
    }
);

export default axiosInstance;