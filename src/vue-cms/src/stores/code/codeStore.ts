import { defineStore } from 'pinia'
import {
  GET_CODE,
  GET_CODE_LIST,
  GET_GROUP_CODE,
  GET_GROUP_CODE_LIST_KEYWORD,
  INSERT_CODE,
  INSERT_GROUP_CODE,
  UPDATE_CODE,
  UPDATE_GROUP_CODE,
  DELETE_CODE,
  DELETE_GROUP_CODE,
  DELETE_CODE_GROUP_CODE_ID
} from "@/api/code/codeApi";
import type {CodeModel, GroupCodeModel} from "@/model/code/codeModel";

export const useCodeStore = defineStore('code', () => {

  const getCodeList = async (
      codeId?:number,
      groupCodeId?:number,
      groupCodName?:string,
      name?:string,
      useYn?:string
  ) => {
    return await GET_CODE_LIST(codeId, groupCodeId, groupCodName, name, useYn);
  }

  const getGroupCodeListKeyword = async (
      searchKey?:string,
      keyword?:string,
  ) => {
    return await GET_GROUP_CODE_LIST_KEYWORD(searchKey, keyword);
  }

  const getGroupCode = async (groupCodeId?:number) => {
    return await GET_GROUP_CODE(groupCodeId);
  }

  const getCode = async (codeId?:number) => {
    return await GET_CODE(codeId);
  }

  const insertGroupCode = async (groupCodeModel?:GroupCodeModel) => {
    return await INSERT_GROUP_CODE(groupCodeModel);
  }

  const insertCode = async (codeModel?:CodeModel) => {
    return await INSERT_CODE(codeModel);
  }

  const updateGroupCode = async (groupCodeModel?:GroupCodeModel) => {
    return await UPDATE_GROUP_CODE(groupCodeModel);
  }

  const updateCode = async (codeModel?:CodeModel) => {
    return await UPDATE_CODE(codeModel);
  }

  const deleteGroupCode = async (groupCodeIds?:Array<number>) => {
    return await DELETE_GROUP_CODE(groupCodeIds);
  }

  const deleteCode = async (codeIds?:Array<number>) => {
    return await DELETE_CODE(codeIds);
  }

  const deleteCodeGroupCodeId = async (groupCodeId?:number) => {
    return await DELETE_CODE_GROUP_CODE_ID(groupCodeId);
  }

  return {
    getCodeList,
    getGroupCodeListKeyword,
    getGroupCode,
    getCode,
    insertGroupCode,
    insertCode,
    updateGroupCode,
    updateCode,
    deleteGroupCode,
    deleteCode,
    deleteCodeGroupCodeId
  }
})
