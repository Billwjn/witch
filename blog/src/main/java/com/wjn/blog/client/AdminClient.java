package com.wjn.blog.client;

import com.wjn.api.AdminApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("WITCH-ADMIN")
public interface AdminClient extends AdminApi {
}
