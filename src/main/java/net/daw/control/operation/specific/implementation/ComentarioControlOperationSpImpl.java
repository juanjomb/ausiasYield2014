/*
 * Copyright (C) 2014 al037805
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.daw.control.operation.specific.implementation;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import net.daw.connection.implementation.BoneConnectionPoolImpl;
import net.daw.connection.publicinterface.ConnectionInterface;
import net.daw.control.operation.publicinterface.ControlOperationInterface;
import net.daw.helper.ExceptionBooster;
import net.daw.helper.FilterBeanHelper;
import net.daw.helper.ParameterCooker;
import net.daw.service.specific.implementation.ComentarioServiceSpImpl;

/**
 *
 * @author al037805
 */
public class ComentarioControlOperationSpImpl implements ControlOperationInterface{
    
    private ConnectionInterface DataConnectionSource = null;
    private Connection oConnection = null;
    private ComentarioServiceSpImpl oComentarioService = null;

    public ComentarioControlOperationSpImpl(HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        try {
            DataConnectionSource = new BoneConnectionPoolImpl();
            oConnection = DataConnectionSource.newConnection();
            oComentarioService = new ComentarioServiceSpImpl(ParameterCooker.prepareObject(request), ParameterCooker.prepareObject(request), oConnection);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":ComentarioControlOperationSpImpl ERROR: " + ex.getMessage()));
        }
    }

    @Override
    public String get(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.get(ParameterCooker.prepareId(request));
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":get ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getaggregateviewone(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.getAggregateViewOne(ParameterCooker.prepareId(request));
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getaggregateviewone ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getprettycolumns(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.getPrettyColumns();
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getprettycolumns ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getcolumns(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.getColumns();
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getcolumns ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getpage(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            Integer intRegsPerPag = ParameterCooker.prepareRpp(request);
            Integer intPage = ParameterCooker.preparePage(request);
            ArrayList<FilterBeanHelper> alFilter = ParameterCooker.prepareFilter(request);
            HashMap<String, String> hmOrder = ParameterCooker.prepareOrder(request);
            result = oComentarioService.getPage(intRegsPerPag, intPage, alFilter, hmOrder);
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getpage ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getpages(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            Integer intRegsPerPag = ParameterCooker.prepareRpp(request);
            ArrayList<FilterBeanHelper> alFilter = ParameterCooker.prepareFilter(request);
            result = oComentarioService.getPages(intRegsPerPag, alFilter);
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getpages ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getregisters(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            ArrayList<FilterBeanHelper> alFilter = ParameterCooker.prepareFilter(request);
            result = oComentarioService.getCount(alFilter);
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getregisters ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String getaggregateviewsome(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            Integer intRegsPerPag = ParameterCooker.prepareRpp(request);
            Integer intPage = ParameterCooker.preparePage(request);
            ArrayList<FilterBeanHelper> alFilter = ParameterCooker.prepareFilter(request);
            HashMap<String, String> hmOrder = ParameterCooker.prepareOrder(request);
            result = oComentarioService.getAggregateViewSome(intRegsPerPag, intPage, alFilter, hmOrder);
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getaggregateviewsome ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String remove(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.remove(ParameterCooker.prepareId(request));
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":remove ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public String set(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oComentarioService.set(ParameterCooker.prepareJson(request));
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return result;
    }

    private void closeDB() throws SQLException, Exception {
        try {
            if (oConnection != null) {
                oConnection.close();
            }
            DataConnectionSource.disposeConnection();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":closeDB ERROR: " + ex.getMessage()));
        }
    }

    @Override
    public String updateOne(HttpServletRequest request) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
