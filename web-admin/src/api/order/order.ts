import instance from "../../utils/http"; // 根据实际路径补全这行import语句

enum API {
    GET_ORDER_LIST = "/order/list",
    DELETE_ORDER_BY_ID = "/order/{id}",
    GET_ORDER_BY_ID = "/order/{id}",
    UPDATE_ORDER = "/order/update"
}

export class OrderService {
    static async list() {
        return instance({
            url: API.GET_ORDER_LIST,
            method: "GET"
        });
    }

    static async deleteOrderById(id: string) {
        const url = API.DELETE_ORDER_BY_ID.replace("{id}", id);
        return instance({
            url,
            method: "DELETE"
        });
    }

    static async getOrderById(id: string) {
        const url = API.GET_ORDER_BY_ID.replace("{id}", id);
        return instance({
            url,
            method: "GET"
        });
    }

    static async updateOrder(order: any) {
        return instance({
            url: API.UPDATE_ORDER,
            method: "PUT",
            data: JSON.stringify(order)
        });
    }
}