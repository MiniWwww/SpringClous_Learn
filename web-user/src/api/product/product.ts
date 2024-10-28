import instance from "../../utils/http";

enum API {
    LIST_PRODUCTS = "/product/list",
    GET_PRODUCT_BY_ID = "/product/{productId}",
}

export class productService{
    static async list(){
        return  instance({
            url:API.LIST_PRODUCTS,
            method:"GET",
        })
    }
    static async getById(productId: string) {
        const url = API.GET_PRODUCT_BY_ID.replace("{productId}", productId);
        return instance({
            url,
            method: "GET"
        });
    }
}