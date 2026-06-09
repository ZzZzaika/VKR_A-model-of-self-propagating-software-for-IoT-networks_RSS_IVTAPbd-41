package diploma;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;
import com.anylogic.engine.omniverse_connector.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.processmodeling.*;

import java.awt.geom.Arc2D;

public class IoTDevice extends Agent
{
  // Parameters

  public 
double  cvssScore;

  /**
   * Returns default value for parameter <code>cvssScore</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _cvssScore_DefaultValue_xjal() {
    final IoTDevice self = this;
    return 0.0;
  }

  public void set_cvssScore( double value ) {
    if (value == this.cvssScore) {
      return;
    }
    double _oldValue_xjal = this.cvssScore;
    this.cvssScore = value;
    onChange_cvssScore_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter cvssScore.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_cvssScore()</code> method instead.
   */
  protected void onChange_cvssScore() {
    onChange_cvssScore_xjal( cvssScore );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_cvssScore_xjal( double oldValue ) {  
  }


  public 
String  deviceName;

  /**
   * Returns default value for parameter <code>deviceName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _deviceName_DefaultValue_xjal() {
    final IoTDevice self = this;
    return 
"Неизвестное устройство" 
;
  }

  public void set_deviceName( String value ) {
    if (value == this.deviceName) {
      return;
    }
    String _oldValue_xjal = this.deviceName;
    this.deviceName = value;
    onChange_deviceName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter deviceName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_deviceName()</code> method instead.
   */
  protected void onChange_deviceName() {
    onChange_deviceName_xjal( deviceName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_deviceName_xjal( String oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    cvssScore = _cvssScore_DefaultValue_xjal();
    deviceName = _deviceName_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "cvssScore":
      if ( _callOnChange_xjal ) {
        set_cvssScore( ((Number) _value_xjal).doubleValue() );
      } else {
        cvssScore = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "deviceName":
      if ( _callOnChange_xjal ) {
        set_deviceName( (String) _value_xjal );
      } else {
        deviceName = (String) _value_xjal;
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "cvssScore": _result_xjal = cvssScore; break;
    case "deviceName": _result_xjal = deviceName; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "cvssScore" );
      list.add( "deviceName" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 latencyPeriod;
  public 
String 
 deviceLogin;
  public 
String 
 devicePassword;
  public 
double 
 minPatchKB;
  public 
double 
 maxPatchKB;
  public 
double 
 coorX;
  public 
double 
 coorY;
  public 
double 
 minInstallSec;
  public 
double 
 maxInstallSec;
  public 
Virus 
 infectingVirus;
  public 
String 
 segment;
  public 
String 
 gatewaySegments;
  public 
String 
 lastInfectionMode;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( IoTDevice.class );

  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 45.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events

  public EventTimeout scanTimerEvent = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == scanTimerEvent ) return "scanTimerEvent";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == scanTimerEvent ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == scanTimerEvent ) {
      _t = 
1000000 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == scanTimerEvent) {
      _t = 
get_Main().scanInterval * minute() 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == scanTimerEvent ) {
      EventTimeout self = _e;

if (!inState(IoTDevice.Infected)) {
	return;
}

Main main = get_Main();
double parentRZero = infectingVirus.rzeroScore;

ArrayList<IoTDevice> visibleTargets = main
		.getVisibleDevices(IoTDevice.this);

ArrayList<IoTDevice> validTargets = new ArrayList<>();
for (IoTDevice d : visibleTargets) {
	if (infectingVirus.canInfect(d)) {
		validTargets.add(d);
	}
}

if (validTargets.size() > 0) {
	int numTargets = (int) min(poisson(main.rzero),
			validTargets.size());
	for (int i = 0; i < numTargets; i++) {
		int idx = uniform_discr(0, validTargets.size() - 1);
		main.createVirus(parentRZero,
				validTargets.get(idx));
	}
} 
;
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 1;


  // Statecharts
  public Statechart<statechart_state> statechart = new Statechart<>( this, (short)2 );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( Statechart _s ) {
    if(_s == this.statechart) return "statechart";
    return super.getNameOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getIdOf( Statechart _s ) {
    if(_s == this.statechart) return 0;
    return super.getIdOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( Statechart _s ) {
    if( _s == this.statechart ) {
      enterState( Susceptible, true );
      return;
    }
    super.executeActionOf( _s );
  }

   // States of all statecharts
   
  public enum statechart_state implements IStatechartState<IoTDevice, statechart_state> {
    Susceptible,
    Exposed,
    Infected,
    Recovered;

    @AnyLogicInternalCodegenAPI
    private Collection<statechart_state> _simpleStatesDeep_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<statechart_state> _fullState_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<statechart_state> _statesInside_xjal;

    @Override
    @AnyLogicInternalCodegenAPI
    public Collection<statechart_state> getSimpleStatesDeep() {
      Collection<statechart_state> result = _simpleStatesDeep_xjal;
      if (result == null) {
        _simpleStatesDeep_xjal = result = calculateAllSimpleStatesDeep();
      }
      return result;
    }
    
    @Override
    public Set<statechart_state> getFullState() {
      Set<statechart_state> result = _fullState_xjal;
      if (result == null) {
        _fullState_xjal = result = calculateFullState();
      }
      return result;
    }
    
    @Override
    @AnyLogicInternalCodegenAPI
    public Set<statechart_state> getStatesInside() {
      Set<statechart_state> result = _statesInside_xjal;
      if (result == null) {
        _statesInside_xjal = result = calculateStatesInside();
      }
      return result;
    }

    @Override
    @AnyLogicInternalCodegenAPI
    public Statechart<statechart_state> getStatechart( IoTDevice _a ) {
      return _a.statechart;
    }
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Susceptible = statechart_state.Susceptible;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Exposed = statechart_state.Exposed;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Infected = statechart_state.Infected;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Recovered = statechart_state.Recovered;


  @AnyLogicInternalCodegenAPI
  private void enterState( statechart_state self, boolean _destination ) {
    switch( self ) {
      case Susceptible:
  	    logToDBEnterState(statechart, self);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Susceptible );
        {
shape.setFillColor(lightGrey); 
;}
        becomeExposed.start();
        return;
      case Exposed:
  	    logToDBEnterState(statechart, self);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Exposed );
        {
shape.setFillColor(gold); 
;}
        becomeInfected.start();
        becomeERecovered.start();
        return;
      case Infected:
  	    logToDBEnterState(statechart, self);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Infected );
        {
traceln("[" + time() + "] " + getName() + " стал Infected");
shape.setFillColor(red);
get_Main().triggerDetectionIfNeeded();
Main main = get_Main();
double parentRZero = infectingVirus.rzeroScore;

Runnable performAttack = () -> {
	ArrayList<IoTDevice> visibleTargets = main
			.getVisibleDevices(IoTDevice.this);

	ArrayList<IoTDevice> validTargets = new ArrayList<>();

	for (IoTDevice d : visibleTargets) {
		if (infectingVirus.canInfect(d)) {
			validTargets.add(d);
		}
	}

	if (validTargets.size() > 0) {
		int numTargets = (int) min(poisson(main.rzero),
				validTargets.size());
		for (int i = 0; i < numTargets; i++) {
			int idx = uniform_discr(0,
					validTargets.size() - 1);
			main.createVirus(parentRZero,
					validTargets.get(idx));
		}
	}
};

performAttack.run();
scanTimerEvent.restart(); 
;}
        becomeRecovered.start();
        return;
      case Recovered:
  	    logToDBEnterState(statechart, self);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Recovered );
        {
traceln("[" + time() + "] " + getName()
		+ " излечен (Recovered)");
shape.setFillColor(green); 
;}
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitState( statechart_state self, Transition _t, boolean _source ) {
    switch( self ) {
      case Susceptible: 
  	    logToDBExitState(statechart, self);
  	    logToDB(statechart, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != becomeExposed) becomeExposed.cancel();
        return;
      case Exposed: 
  	    logToDBExitState(statechart, self);
  	    logToDB(statechart, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != becomeInfected) becomeInfected.cancel();
        if ( !_source || _t != becomeERecovered) becomeERecovered.cancel();
        return;
      case Infected: 
  	    logToDBExitState(statechart, self);
  	    logToDB(statechart, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != becomeRecovered) becomeRecovered.cancel();
        {
scanTimerEvent.reset(); 
;}
        return;
      case Recovered: 
  	    logToDBExitState(statechart, self);
  	    logToDB(statechart, _t, self);
      // (Simple state (not composite))
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitInnerStates( statechart_state _destination ) {
    statechart_state _state = statechart.getActiveSimpleState();
    while( _state != _destination ) {
			exitState( _state, null, false );
			_state = _state.getContainerState();
		}
	}
  
  public TransitionTimeout becomeInfected = new TransitionTimeout( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionTimeout _t ) {
    if ( _t == becomeInfected ) return "becomeInfected";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionTimeout _t ) { 
    if ( _t == becomeInfected ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionTimeout self ) {
    if ( self == becomeInfected ) {
      exitState( Exposed, self, true );
      {
get_Main().updateAllDS(); 
;}
          enterState( Infected, true );
      return;
    }
    super.executeActionOf( self );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( TransitionTimeout _t ) {
    double _value;
    if ( _t == becomeInfected ) {
      _value = 
latencyPeriod 
;
      _value = toModelTime( _value, MINUTE );
      return _value;
    }
    return super.evaluateTimeoutOf( _t );
  }



  public TransitionMessage becomeExposed = new TransitionMessage( this );
  public TransitionMessage becomeRecovered = new TransitionMessage( this );
  public TransitionMessage becomeERecovered = new TransitionMessage( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionMessage _t ) {
    if ( _t == becomeExposed ) return "becomeExposed";
    if ( _t == becomeRecovered ) return "becomeRecovered";
    if ( _t == becomeERecovered ) return "becomeERecovered";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionMessage _t ) { 
    if ( _t == becomeExposed ) return statechart;
    if ( _t == becomeRecovered ) return statechart;
    if ( _t == becomeERecovered ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionMessage self, Object _msg ) {
    if ( self == becomeExposed ) {
      exitState( Susceptible, self, true );
      {
        Object msg = (Object) _msg;
infectingVirus = get_Main().lastInfectingVirus;
latencyPeriod = infectingVirus.latencyPeriod;
get_Main().updateAllDS();
lastInfectionMode = get_Main().attackMode;
traceln("[" + time() + "] " + getName()
		+ " заражён (Exposed), R0="
		+ infectingVirus.rzeroScore); 
;}
          enterState( Exposed, true );
      return;
    }
    if ( self == becomeRecovered ) {
      exitState( Infected, self, true );
      {
        Object msg = (Object) _msg;
get_Main().updateAllDS();

Main main = get_Main();
String mode = main.passwordChangeMode;
if ("always".equals(mode) || ("bruteforce".equals(mode)
		&& "bruteforce".equals(lastInfectionMode))) {
	deviceLogin = "user" + (int) uniform(1000, 9999);
	devicePassword = "pass" + (int) uniform(10000, 99999);
	traceln("[" + time() + "] " + getName()
			+ " излечен, новые учётные данные: "
			+ deviceLogin + ":" + devicePassword);
} 
;}
          enterState( Recovered, true );
      return;
    }
    if ( self == becomeERecovered ) {
      exitState( Exposed, self, true );
      {
        Object msg = (Object) _msg;
get_Main().updateAllDS();

Main main = get_Main();
String mode = main.passwordChangeMode;
if ("always".equals(mode) || ("bruteforce".equals(mode)
		&& "bruteforce".equals(lastInfectionMode))) {
	deviceLogin = "user" + (int) uniform(1000, 9999);
	devicePassword = "pass" + (int) uniform(10000, 99999);
	traceln("[" + time() + "] " + getName()
			+ " излечен, новые учётные данные: "
			+ deviceLogin + ":" + devicePassword);
} 
;}
          enterState( Recovered, true );
      return;
    }
    super.executeActionOf( self, _msg );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testMessageOf( TransitionMessage _t, Object _msg ) {
    if ( _t == becomeExposed ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"EXPOSE" 
;
      return msg.equals( _g );
    }
    if ( _t == becomeRecovered ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"PATCH" 
;
      return msg.equals( _g );
    }
    if ( _t == becomeERecovered ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"PATCH" 
;
      return msg.equals( _g );
    }
    return super.testMessageOf( _t, _msg );
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _deviceNameText_Font = new Font("SansSerif", 0, 5 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _segmentText_Font = _deviceNameText_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cvssScoreText_Font = new Font("SansSerif", 1, 9 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _loginText_Font = _deviceNameText_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _passwordText_Font = _deviceNameText_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _shape = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _deviceNameText = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _segmentText = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _cvssScoreText = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _loginText = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _passwordText = 6;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 7;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(shape, deviceNameText, segmentText, cvssScoreText, loginText, passwordText);
  }

  protected ShapeOval shape;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _deviceNameText_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
deviceName 
);
  }
  
  protected ShapeText deviceNameText;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _segmentText_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Подсеть: " + segment 
);
  }
  
  protected ShapeText segmentText;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cvssScoreText_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
cvssScore 
);
  }
  
  protected ShapeText cvssScoreText;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _loginText_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Логин: " + deviceLogin 
);
  }
  
  protected ShapeText loginText;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _passwordText_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Пароль: " + devicePassword 
);
  }
  
  protected ShapeText passwordText;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    shape = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       black, white,
	   11.875, 11.875, 10.0, 1.0, LINE_STYLE_SOLID );
    deviceNameText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -23.0, 0.0, 0.0,
        black,"",
        _deviceNameText_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _deviceNameText_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    segmentText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -19.0, 0.0, 0.0,
        black,"text",
        _segmentText_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _segmentText_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    cvssScoreText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -5.0, 0.0, 0.0,
        black,"",
        _cvssScoreText_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cvssScoreText_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    loginText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 12.0, 0.0, 0.0,
        black,"text",
        _loginText_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _loginText_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    passwordText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 17.0, 0.0, 0.0,
        black,"text",
        _passwordText_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _passwordText_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public IoTDevice( Engine engine, Agent owner, AgentList<? extends IoTDevice> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public IoTDevice() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public IoTDevice( double cvssScore, String deviceName ) {
    markParametersAreSet();
    this.cvssScore = cvssScore;
    this.deviceName = deviceName;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_IoTDevice_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( IoTDevice.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( IoTDevice.this, getElementProperty( "diploma.IoTDevice.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( IoTDevice.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    scanTimerEvent.start();
    statechart.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_IoTDevice_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_IoTDevice_xjal() {
    infectingVirus = 
null 
;
    segment = 
"Основная сеть" 
;
    gatewaySegments = 
"" 
;
    lastInfectionMode = 
"" 
;
  }

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Main ) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient diploma.Main main;

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    statechart.fireEvent( _msg_xjal );
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends IoTDevice> getPopulation() {
    return (AgentList<? extends IoTDevice>) super.getPopulation();
  }

  public List<? extends IoTDevice> agentsInRange( double distance ) {
    return (List<? extends IoTDevice>) super.agentsInRange( distance );
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    statechart.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    scanTimerEvent.onDestroy();
    statechart.onDestroy();
    super.onDestroy();
  }


}
