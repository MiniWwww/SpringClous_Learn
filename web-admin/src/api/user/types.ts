export interface LoginForm {
    username: string,
    password: string
}

export interface RegisterForm {
    username: string,
    password: string,
    email:string
}
export interface User extends RegisterForm{
    id: string,
    phone: string,
    avatar: string,
    roleId: string,
    age:string,
    createTime:string,
    status:string,

}





