import { defineStore } from 'pinia'
import {
  DELETE_ROLE,
  GET_ROLE,
  GET_ROLE_LIST,
  GET_ROLE_LIST_KEYWORD,
  INSERT_ROLE,
  UPDATE_ROLE
} from "@/api/role/roleApi";
import type {RoleModel} from "@/model/role/roleModel";

export const useRoleStore = defineStore('role', () => {

  const getRoleList = async (
      roleId?: number,
      name?: string,
      useYn?: string
  ) => {
    return await GET_ROLE_LIST(roleId, name, useYn);
  }

  const getRoleListKeyword = async (
      searchKey?: string,
      keyword?: string
  ) => {
    return await GET_ROLE_LIST_KEYWORD(searchKey, keyword);
  }

  const getRole = async (roleId: number) => {
    return await GET_ROLE(roleId);
  }

  const insertRole = async (roleModel : RoleModel) => {
    return await INSERT_ROLE(roleModel);
  }

  const updateRole = async (roleModel : RoleModel) => {
    return await UPDATE_ROLE(roleModel);
  }

  const deleteRole = async (roleIds : Array<number>) => {
    return await DELETE_ROLE(roleIds);
  }

  return {
    getRoleList,
    getRoleListKeyword,
    getRole,
    insertRole,
    updateRole,
    deleteRole
  }
})
