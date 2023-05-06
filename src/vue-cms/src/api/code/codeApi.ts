import axiosInstance from "@/api/axiosInit";

export const GET_CODE_LIST = async (
    codeId?: number,
    groupCodeId?: number,
    groupCodeName?: string,
    name?: string,
    useYn?: string
) => {
     return await axiosInstance.get(
         `/code?
          codeId=${codeId ? codeId: "0"}&
          groupCodeId=${groupCodeId ? groupCodeId : "0"}&
          groupCodeName=${groupCodeName ? groupCodeName : ""}&
          name=${name ? name : ""}&
          userYn=${useYn ? useYn : "Y"}`
     );
}

export const GET_GROUP_CODE_LIST_KEYWORD = async (
    searchKey?: string,
    keyword?: string
) => {
     return await axiosInstance.get(
         `/groupCode/keyword?searchKey=${searchKey ? searchKey : ""}&keyword=${keyword ? keyword : ""}`
     );
}