import { updateCurrentUser } from '../../action-mappers/login-actions';
import { connect } from 'react-redux';
import { LoginComponent } from './LoginComponent';
import { IState } from '../../reducers';


const mapStateToProps = (state:IState) => {
    return {
        loginMessage:state.userState.loginMessage
    }
}

const mapDispatchToProps = {
    updateCurrentUser
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent)