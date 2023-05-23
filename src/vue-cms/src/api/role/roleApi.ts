import type {RoleModel} from "@/model/role/roleModel";
import axiosInstance from "@/api/axiosInit";

export const GET_ROLE_LIST = async (
    roleId?: number,
    name?: string,
    useYn?: string
) => {
     return await axiosInstance.get(
         "/role" ,
         {
               params : {
                    roleId: roleId,
                    name: name,
                    useYn: useYn
               }
          }
    );
}

export const GET_ROLE_LIST_KEYWORD = async (
    searchKey?: string,
    keyword?: string
) => {
    return await axiosInstance.get(
        "/role/keyword" ,
        {
            params : {
                searchKey: searchKey,
                keyword: keyword
            }
        }
    );
}

export const GET_ROLE = async (roleId: number) => {
     return await axiosInstance.get(`/role/${roleId}`);
}

export const INSERT_ROLE = async (roleModel : RoleModel) => {
     return await axiosInstance.post("/role", roleModel);
}

export const UPDATE_ROLE = async (roleModel : RoleModel) => {
     return await axiosInstance.put("/role", roleModel);
}

export const DELETE_ROLE = async (roleIds : Array<number>) => {
     return await axiosInstance.delete("/role", {
          data: roleIds
     });
}