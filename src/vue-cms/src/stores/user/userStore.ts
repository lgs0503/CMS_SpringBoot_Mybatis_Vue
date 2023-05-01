import { ref } from 'vue'
import { defineStore } from 'pinia'
import {DELETE_USER, GET_USER, GET_USER_LIST, INSERT_USER, LOGIN, UPDATE_USER} from "@/api/user/userApi";
import type {LoginModel, UserModel} from "@/model/user/userModel";

export const useUserStore = defineStore('user', () => {
  const userList = ref([]);

  const getUserList = async (
      userNo?: number,
      userId?: string,
      korName?: string,
      roleId?: number,
      useYn?: string
  ) => {
    return await GET_USER_LIST(userNo, userId, korName, roleId, useYn);
  }

  const getUser = async (
      userNo: number
  ) => {
    return await GET_USER(userNo);
  }

  const login = async (loginModel: LoginModel) => {
    return await LOGIN(loginModel);
  }

  const insertUser = async (userModel : UserModel) => {
    return await INSERT_USER(userModel);
  }

  const updateUser = async (userModel : UserModel) => {
    return await UPDATE_USER(userModel);
  }

  const deleteUser = async (userIds : Array<number>) => {
    return await DELETE_USER(userIds);
  }

  return { userList, getUserList, login, insertUser, updateUser, deleteUser }
})
