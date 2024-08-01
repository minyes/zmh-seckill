package com.zmh.app.common;

import java.util.List;

/**
 * @Description: BaseMapper
 * @author: zhou ming hao
 * @date: 2024年07月31日 0:48
 *
 */

public interface PlusMapper<S,T> {

    List<S> toList(List<T> list);

    S convert(T source);
}
