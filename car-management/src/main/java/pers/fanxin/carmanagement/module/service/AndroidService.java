package pers.fanxin.carmanagement.module.service;

import org.json.JSONObject;

import pers.fanxin.carmanagement.module.vo.AndroidData;

public interface AndroidService {
	AndroidData callfunction(JSONObject inData);
}
