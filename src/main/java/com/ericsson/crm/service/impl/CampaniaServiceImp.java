package com.ericsson.crm.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ericsson.crm.commons.GenericServiceImp;
import com.ericsson.crm.model.Campania;
import com.ericsson.crm.model.DetalleCampania;
import com.ericsson.crm.model.RequestCampania;
import com.ericsson.crm.model.Tablas;
import com.ericsson.crm.repository.CampaniaRepository;
import com.ericsson.crm.repository.TablasRepository;
import com.ericsson.crm.service.CampaniaService;

@Service
public class CampaniaServiceImp extends GenericServiceImp<Campania, Integer> implements CampaniaService {

	@Autowired
	CampaniaRepository dao;
	

	@Autowired
	TablasRepository tableRepository;

	@Override
	public RequestCampania saveOrderAndDetails(RequestCampania obj) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		StringBuilder sbFilter = new StringBuilder("");
	
		for (String fechaInicio : obj.getFchInicio()) {

			LocalDate date = LocalDate.parse(fechaInicio, formatter);

			Campania camp = new Campania();
			camp.setNombre(obj.getNombre());
			camp.setTipoCanalId(obj.getTipoCanalId());
			camp.setTipoProductoId(obj.getTipoProductoId());
			camp.setMensaje(obj.getMensaje());
			camp.setCampos(toString(obj.getCampos()));
			camp.setFchInicio(date);
		    camp.setHoraInicio(obj.getHoraInicio());
		    camp.setPrioridad(obj.getPrioridad()==true ? 1 : 0);
		    camp.setRemitente(obj.getRemitente());
			camp.setEstado("INICIAL");

			ArrayList<String> lstTable = new ArrayList<String>();
			
			for (DetalleCampania item : obj.getDetalle()) {
				lstTable.add(tableName(item.getFuncionalidad()));
				sbFilter.append(tableName(item.getVariables())).append(",");
			}
			
			List<String> lstTable2 = lstTable.stream().distinct().collect(Collectors.toList());  
			
			String strListFunct = String.join(",", lstTable2);
			String strListFilter = sbFilter.toString();
			
			if (strListFunct.length() > 0)
				strListFunct = strListFunct.substring(0, strListFunct.length() - 1);
			    strListFilter = strListFilter.substring(0, strListFilter.length() - 1);
			
			camp.setFuncionalidad(strListFunct);
			camp.setFiltros(strListFilter);
			
			dao.save(camp);
		}

		return obj;
	}

	@Override
	public Campania updateEjecution(Integer id) {
		String horaActual = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		LocalDateTime datetime = LocalDateTime.now();
		
		Campania camp = dao.getById(id);
		camp.setFchFin(null);
		camp.setEstado("INICIAL");
		camp.setFchInicio(datetime.toLocalDate());
		camp.setHoraInicio(horaActual);
		
		dao.save(camp);
		return camp;
	}

	
	@Override
	public CrudRepository<Campania, Integer> getDao() {
		return dao;
	}

	public static String toString(String[] array) {
		String result = "";
		if (array.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (String s : array) {
				sb.append(s).append(",");
			}
			result = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return result;
	}
	
	public String tableName(String name) {
		String nametable="";
		Tablas table = tableRepository.findByDescripcion(name);
		if (table != null) {
			nametable = table.getTablaReferencia();
		}else {
			nametable = name;
		}
		return nametable;
	}
	
	
}
