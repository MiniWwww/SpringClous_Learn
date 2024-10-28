enum STATE {
    TOKEN = "token"
}


export const SET_TOKEN = (token: any) => {
    localStorage.setItem(STATE.TOKEN,JSON.stringify(token) )
}
//本地存储获取数据
export const GET_TOKEN = () => {
    if (localStorage.getItem(STATE.TOKEN)!=null) {
        // @ts-ignore
        return JSON.parse(localStorage.getItem(STATE.TOKEN))
    }
    return null;
}
//本地存储删除数据方法
export const REMOVE_TOKEN = () => {
    localStorage.removeItem(STATE.TOKEN)
}
//获取权限
// export const GET_ROLE = () => {
//     if (localStorage.getItem('user_adms')!=null) {
//         // @ts-ignore
//         return JSON.parse(localStorage.getItem('user_adms'))['roleId']
//     }
//     return 2;
// }
//获取用户id
export const GET_USERID=()=>{
    if (localStorage.getItem('cloud_sc_userInfo')!=null) {
        // @ts-ignore
        return JSON.parse(localStorage.getItem('cloud_sc_userInfo'))['id']
    }
    return null;
}
export const GET_USERNAME=()=>{
    if (localStorage.getItem('cloud_sc_userInfo')!=null) {
        // @ts-ignore
        return JSON.parse(localStorage.getItem('cloud_sc_userInfo'))['username']
    }
    return null;
}
export const GET_USEREMAIL=()=>{
    if (localStorage.getItem('cloud_sc_userInfo')!=null) {
        // @ts-ignore
        return JSON.parse(localStorage.getItem('cloud_sc_userInfo'))['email']
    }
    return null;
}

// export const GET_USER_AVATAR=()=>{
//     if (localStorage.getItem('user_adms')!=null) {
//         // @ts-ignore
//         return JSON.parse(localStorage.getItem('user_adms'))['avatar']
//     }
//     return null;
// }

// export const GET_USERNAME=()=>{
//     if (localStorage.getItem('user_adms')!=null) {
//         // @ts-ignore
//         return JSON.parse(localStorage.getItem('user_adms'))['name']
//     }
//     return null;
// }