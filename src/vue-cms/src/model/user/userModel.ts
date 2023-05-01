
export interface UserModel {
    userNo: number,
    userId: string,
    password: string,
    korName: string,
    engName: string,
    birthday: string,
    gender: string,
    address: string,
    addressDtl: string,
    phoneNum: string,
    email: string,
    useYn: string,
    fileId: number,
    roleId: number
}

export interface LoginModel {
    userId: string,
    password: string
}