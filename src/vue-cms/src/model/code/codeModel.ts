
export interface CodeModel {
    codeId:number,
    groupCodeId:number,
    name:string,
    korName:string,
    description:string,
    value1:string,
    value2:string,
    value3:string,
    value4:string,
    value5:string,
    useYn:string,
    sort:number,
    createUser:string,
    createDate:string,
    updateUser:string,
    updateDate:string
}

export interface GroupCodeModel {
    groupCodeId:number,
    name:string,
    korName:string,
    description:string,
    useYn:string,
    createUser:string,
    createDate:string,
    updateUser:string,
    updateDate:string
}