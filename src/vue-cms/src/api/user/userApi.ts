import type {Login} from "@/model/user/userModel";
import axiosInstance from "@/api/axiosInit";

export const LOGIN = async (loginModel: Login) => {
     return await axiosInstance.post("/user/login", loginModel);
}