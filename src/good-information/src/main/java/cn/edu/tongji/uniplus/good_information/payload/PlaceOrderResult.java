package cn.edu.tongji.uniplus.good_information.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PlaceOrderResult
 *
 * @author 卓正一
 * @since 2021/12/30 2:26 AM
 */
@Data
@AllArgsConstructor
public class PlaceOrderResult {
    private String msg;
    private Boolean success;
}
