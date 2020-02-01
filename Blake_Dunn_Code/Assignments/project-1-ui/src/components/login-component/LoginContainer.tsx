import { updateCurrentUser } from '../../action-mappers/login-actions';
import { connect } from 'tls';
import { LoginComponent } from './LoginComponent';


const mapStateToProps = (state:IState) => {
    return {
        loginMessage:state.userState.loginMessage
    }
}

const mapDispatchToProps = {
    updateCurrentUser
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent)