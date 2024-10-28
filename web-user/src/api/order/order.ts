import instance from "../../utils/http"; // 根据实际路径补全这行import语句

enum API {
    UPDATE_ORDER = "/order/add"
}

export class OrderService {
    static async add(order: any) {
        return instance({
            url: API.UPDATE_ORDER,
            method: "POST",
            data: JSON.stringify(order)
        });
    }
}