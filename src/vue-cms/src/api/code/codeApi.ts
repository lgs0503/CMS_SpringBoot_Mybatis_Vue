import axiosInstance from "@/api/axiosInit";
import type {CodeModel, GroupCodeModel} from "@/model/code/codeModel";

export const GET_CODE_LIST = async (
    codeId?: number,
    groupCodeId?: number,
    groupCodeName?: string,
    name?: string,
    useYn?: string
) => {
     return await axiosInstance.get(
         "/code",
         {
               params: {
                    codeId: codeId,
                    groupCodeId: groupCodeId,
                    groupCodeName: groupCodeName,
                    name: name,
                    useYn: useYn
               }
         }
     );
}

export const GET_GROUP_CODE_LIST_KEYWORD = async (
    searchKey?: string,
    keyword?: string
) => {
     return await axiosInstance.get(
         "/groupCode/keyword",
         {
             params: {
                 searchKey: searchKey,
                 keyword: keyword
             }
         }
     );
}

export const GET_GROUP_CODE = async (
    groupCodeId?: number
) => {
    return await axiosInstance.get(`/groupCode/${groupCodeId}`);
}

export const GET_CODE = async (
    codeId?: number
) => {
    return await axiosInstance.get(`/code/${codeId}`);
}

export const INSERT_GROUP_CODE = async (
    groupCodeModel?: GroupCodeModel
) => {
    return await axiosInstance.post("/groupCode", groupCodeModel);
}

export const INSERT_CODE = async (
    codeModel?: CodeModel
) => {
    return await axiosInstance.post("/code", codeModel);
}

export const UPDATE_GROUP_CODE = async (
    groupCodeModel?: GroupCodeModel
) => {
    return await axiosInstance.put("/groupCode", groupCodeModel);
}

export const UPDATE_CODE = async (
    codeModel?: CodeModel
) => {
    return await axiosInstance.put("/code", codeModel);
}

export const DELETE_GROUP_CODE = async (
    groupCodeIds?: Array<number>
) => {
    return await axiosInstance.delete("/groupCode", {
        data: groupCodeIds
    });
}

export const DELETE_CODE = async (
    codeIds?: Array<number>
) => {
    return await axiosInstance.delete("/code", {
        data: codeIds
    });
}

export const DELETE_CODE_GROUP_CODE_ID = async (
    groupCodeId?: number
) => {
    return await axiosInstance.delete("/code/groupCodeId", {
        data: groupCodeId
    });
}