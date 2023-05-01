import type {LoginModel, UserModel} from "@/model/user/userModel";
import axiosInstance from "@/api/axiosInit";

export const GET_USER_LIST = async (
    userNo?: number,
    userId?: string,
    korName?: string,
    roleId?: number,
    useYn?: string
) => {
     return await axiosInstance.get(`/user?userNo=${userNo}&userId=${userId}&korName=${korName}&roleId=${roleId}&userYn=${useYn}`);
}

export const GET_USER = async (userNo: number) => {
     return await axiosInstance.get(`/user/${userNo}`);
}

export const LOGIN = async (loginModel: LoginModel) => {
     return await axiosInstance.post("/user/login", loginModel);
}

export const INSERT_USER = async (userModel : UserModel) => {
     return await axiosInstance.post("/user", userModel);
}

export const UPDATE_USER = async (userModel : UserModel) => {
     return await axiosInstance.put("/user", userModel);
}

export const DELETE_USER = async (userIds : Array<number>) => {
     return await axiosInstance.delete("/user", {
          data: userIds
     });
}