import { defineStore } from 'pinia'
import {GET_CODE_LIST, GET_GROUP_CODE_LIST_KEYWORD} from "@/api/code/codeApi";

export const useCodeStore = defineStore('code', () => {

  const getCodeList = async (
      codeId?: number,
      groupCodeId?: number,
      groupCodName?: string,
      name?: string,
      useYn?: string
  ) => {
    return await GET_CODE_LIST(codeId, groupCodeId, groupCodName, name, useYn);
  }

  const getGroupCodeListKeyword = async (
      searchKey?: string,
      keyword?: string,
  ) => {
    return await GET_GROUP_CODE_LIST_KEYWORD(searchKey, keyword);
  }

  return { getCodeList, getGroupCodeListKeyword }
})
