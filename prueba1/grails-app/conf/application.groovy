

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'prueba1.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'prueba1.security.UserRole'
grails.plugin.springsecurity.authority.className = 'prueba1.security.Role'
//grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
//grails.plugin.springsecurity.useRoleGroups = true

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
    [pattern: '/error',                access: ['permitAll']],
    [pattern: '/index',                access: ['permitAll']],
    [pattern: '/index.gsp',            access: ['permitAll']],
    [pattern: '/shutdown',             access: ['permitAll']],
    [pattern: '/assets/**',            access: ['permitAll']],
    [pattern: '/**/js/**',             access: ['permitAll']],
    [pattern: '/**/css/**',            access: ['permitAll']],
    [pattern: '/**/images/**',         access: ['permitAll']],
    [pattern: '/**/favicon.ico',       access: ['permitAll']],
    [pattern: '/login/**',             access: ['permitAll']],
    [pattern: '/logout/**',            access: ['permitAll']],
    [pattern: '/dbconsole/**',         access: ['permitAll']],
    [pattern: '/console/**', 	       access: ['permitAll']],
    [pattern: '/' ,                    access: ['ROLE_ADMIN']],
    [pattern: '/extendido/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/articulos/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/campista/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/mochila/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/color/**', 	       access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = '/login/auth'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'prueba1.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'prueba1.security.UserRole'
grails.plugin.springsecurity.authority.className = 'prueba1.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

